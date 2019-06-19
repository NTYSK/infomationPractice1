#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<sys/socket.h>
#include<sys/un.h>
#include<arpa/inet.h>

#define SOCK_NAME "./socket"

int main()
{
  int i,dict_size;
  int fd1, fd2;
  FILE *fp;
  int len;
  int ret;
  char buf[1024];
  struct sockaddr_in saddr;
  struct sockaddr_in caddr;

  //read file
  char a[1024],s[1024];
  char alf_name[100][1024];
  char jp_name[100][1024];
  if ((fp = fopen("dic-w.txt", "r")) == NULL) {
      printf("file open error\n");
      exit(EXIT_FAILURE);
  }
  i=0;
  dict_size=0;
  while(fgets(s, 1024, fp) != NULL) {
      sscanf(s ,"%s %s", alf_name[i], jp_name[i]);
      i++;
  }
  dict_size=i;
  strcpy(alf_name[dict_size],"not in dict");  
  fclose(fp);

  //set socket
  if((fd1 = socket(AF_INET, SOCK_STREAM,0)) < 0)
  {
    perror("socket");
    exit(1);
  }
  memset((char *)&saddr, 0, sizeof(saddr));
  saddr.sin_family = AF_INET;
  saddr.sin_addr.s_addr=INADDR_ANY;
  saddr.sin_port=htons(5000);
  //strcpy(saddr.sun_path, SOCK_NAME);

  //connection setting
  unlink(SOCK_NAME);
  if(bind(fd1, (struct sockaddr *)&saddr, (socklen_t)sizeof(saddr)) < 0)
  {
    perror("bind");
    exit(1);
  }

  if(listen(fd1, 5)<0)
  {
    perror("listen");
    exit(1);
  }

  while(1)
  {
    len = sizeof(caddr);
    if((fd2 = accept(fd1, (struct sockaddr *)&caddr, (socklen_t *)&len))<0)
    {
      perror("accept");
      exit(1);
    }
    fprintf(stderr, "Connection established: socket %d used.\n", fd2);

    while((ret = read(fd2, buf, 1024)) > 0)
    {
      fprintf(stderr, "read: %s\n", buf);
      strcpy(s, buf);
      for(i=0;i<dict_size;i++)
      {
	if(strstr(s,alf_name[i]) != NULL)
	{
	  strcpy(buf, jp_name[i]);
	  break;
	}
	if(i==dict_size-1)strcpy(buf, alf_name[dict_size]);
      }
      //fprintf(stderr, "write: %s\n", buf);
      write(fd2, buf, strlen(buf) + 1);
      fsync(fd2);
    }
    close(fd2);
  }
  close(fd1);
  return 0;
}
