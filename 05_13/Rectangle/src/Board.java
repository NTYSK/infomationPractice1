String exit=s;

String exitname(){
	exitname = this.exit
	return exitname
}
for(String s="";!(s.equals("9"));)
        {
            try{
                System.out.println("==========================");
                System.out.println("select number");
                System.out.println("1:create");
                System.out.println("2:setcolor");
                System.out.println("3:move");
                System.out.println("4:expand/shrink");
                System.out.println("5:delete");
                System.out.println("6:deleteAll");
                System.out.println("7:intersect");
                System.out.println("8:displayBoard");
                System.out.println("9:exit");
                System.out.println("==========================");
                s = scan.next();
                s=s.toUpperCase();
                int m = 0;
                String[] commands={"create","setcolor","move","expand/shrink","deletedeleteAll","intersect","exit"};
                //comandsを小文字に変換し番号に対応
                for(String cm:commands)
                {
                    m++;
                    if(s.equalsIgnoreCase(cm))
                    {
                        s=Integer.toString(m);
                        break;
                    }
                }
                switch (s)
                {
                    case "1"://create
                        this.Create();
                        break;
                    case "2"://setcolor
                        this.Color();
                        break;
                    case "3"://move
                        this.Move();
                        break;
                    case "4"://expand_shrink
                        this.ExpandShrink();
                        break;
                    case "5"://delete いらない
                        this.Delete();
                        break;
                    case "6"://deleteAll いらない
                        this.DeleteAll();
                        break;
                    case "7"://intersect 
                        this.Intersect();
                        break;
                    case "8"://displayBoard いらない
                        this.DisplayBoard();
                        break;
                    case "9"://exit いらない
                        this.Exit();
                        break;
                    default:
                        System.out.println("入力ミスです、1~8までのの番号を入力してください");
                        break;
                }
            //予想外の入力に対する例外処理
            }catch(InputMismatchException e){
                    System.out.println("入力ミスです、数字を入力してください");
                    //バッファのクリア
                    scan.nextLine();
            }
        }
    }