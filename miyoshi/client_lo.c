/*
  socket connection client profram.
*/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/socket.h>
#include<sys/un.h>
#include<arpa/inet.h>

#define SOCKET_NAME "./socket"

int main(int argc,char *argv[])
{
  struct sockaddr_in saddr;//socket adress structure
  //struct hostnet *hp;
  int i;
  int soc,p_id;
  char buf[1024];
  //make child process
  if((p_id=fork())<0)
  {
    printf("faild to make child process");
    exit(1);
  }
  if(0 == p_id)
  {
    sleep(10);
    return 0;
  }
  if((soc = socket(AF_INET,SOCK_STREAM,0))<0)
  {
    perror("socket");
    exit(1);
  }

  /*get host local ip adress*/
  /*if(hp=gethostbyname("og059")==NULL)
  {
    pe
  }*/

  /*connection between process and process*/
  int port = atoi(argv[2]);//
  memset((char *)&saddr, 0, sizeof(saddr));
  saddr.sin_family = AF_INET;
  saddr.sin_addr.s_addr=inet_addr(argv[1]);
  saddr.sin_port=htons(port);
  //strcpy(saddr.sun_path, SOCKET_NAME);

  if(connect(soc, (struct sockaddr *)&saddr, (socklen_t)sizeof(saddr)) < 0)
  {
    perror("connect");
    exit(1);
  }
  fprintf(stderr, "connection establishd:socket %d usd.\n", soc);

  while(fgets(buf, 1024, stdin))
  {
    if(buf[strlen(buf)-1] == '\n')buf[strlen(buf)-1] = '\0';
    write(soc, buf, strlen(buf)+1);
    fsync(soc);//書き込みをすぐやらせる
    read(soc, buf, 1024);
    fprintf(stdout, "read: %s\n", buf);

  }

  close(soc);
  return 0;
}
