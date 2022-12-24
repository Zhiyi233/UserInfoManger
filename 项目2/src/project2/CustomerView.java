package project2;

/**
 * CustomerView为主模块，负责菜单的显示和处理用户操作
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView(){
        Customer c1 = new Customer("张三",'男',14,"1898028229","djfdkjfka@qq.com");
        customerList.addCustomer(c1);
    }
    public void enterMainMenu(){
        Boolean isFlag =true;

        while(isFlag){
            System.out.println(" -----------------客户信息管理软件-----------------");
            System.out.println("                  1 添 加 客 户 ");
            System.out.println("                  2 修 改 客 户 ");
            System.out.println("                  3 删 除 客 户 ");
            System.out.println("                  4 客 户 列 表 ");
            System.out.println("                  5 退       出");
            System.out.println("                  请选择(1-5)：_\n");
            char selection = CMUtility.readMenuSelection();

            switch (selection){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("是否退出(Y/N)");
                    char exit = CMUtility.readConfirmSelection();
                    if(exit == 'Y'){
                        isFlag = false;
                    }

            }
        }
    }

    private void addNewCustomer(){
        //char name = CMUtility.readChar();
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);
        System.out.print("性别：");
        char gender = CMUtility.readChar();

        System.out.print("年龄：");
        int age = CMUtility.readInt();

        System.out.print("电话：");
        String phone = CMUtility.readString(11);

        System.out.print("邮箱：");
        String email = CMUtility.readString(20);

        boolean check = customerList.addCustomer(new Customer(name,gender,age,phone,email));

        if(check){
            System.out.println("---------------------添加完成---------------------\n");
        }else{
            System.out.println("当前客户目录已满。");
        }


    }
    private void modifyCustomer(){
        System.out.println("---------------------修改客户---------------------");
        Customer newCust;
        int number;

        for(;;){
            System.out.print("请选择待修改客户编号(-1退出)：");
            number = CMUtility.readInt();

            if(number == -1){
                return;
            }

            newCust = customerList.getCustomer(number-1);

            if(newCust == null){
                System.out.println("无法找到指定用户");
            }else{
                break;
            }
        }

        System.out.print("姓名"+"("+newCust.getName()+")");
        String modifyName = CMUtility.readString(10,newCust.getName());

        System.out.print("性别"+"("+newCust.getGender()+")");
        char modifyGender = CMUtility.readChar(newCust.getGender());

        System.out.print("年龄"+"("+newCust.getAge()+")");
        int modifyAge = CMUtility.readInt(newCust.getAge());

        System.out.print("电话"+"("+newCust.getPhone()+")");
        String modifyPhone = CMUtility.readString(13,newCust.getPhone());

        System.out.print("邮箱"+"("+newCust.getEmail()+")");
        String modifyEmail = CMUtility.readString(20,newCust.getEmail());

        boolean replace = customerList.replaceCustomer(number-1,new Customer(modifyName,modifyGender,modifyAge,modifyPhone,modifyEmail));
        if(replace){
            System.out.println("---------------------修改完成---------------------\n");
        }else{
            System.out.println("---------------------修改失败---------------------\n");

        }


    }

    private void deleteCustomer(){
        System.out.println("---------------------删除客户---------------------");
        Customer delCust;
        int number;

        for(;;){
            System.out.print("请选择待删除客户编号(-1退出): ");
            number = CMUtility.readInt();

            if(number == -1){
                return;
            }

            delCust = customerList.getCustomer(number-1);

            if(delCust == null){
                System.out.println("无法找到指定用户");
            }else{
                break;
            }
        }
        System.out.println("确认是否删除(Y/N): ");
        char delete = CMUtility.readConfirmSelection();
        if(delete == 'Y'){
            boolean result = customerList.deleteCustomer(number-1);
            if(result){
                System.out.println("---------------------删除完成---------------------\n");
            }else{
                System.out.println("---------------------删除失败---------------------\n");
            }
        }
    }
    private void listAllCustomers(){
        String details = "编号\t姓名\t性别\t年龄\t电话\t邮箱";

        System.out.println("---------------------------客户列表---------------------------\n");

        if(customerList.getTotal() == 0){
            System.out.println("没有客户数据");
        }else{
            System.out.println(details+"\n");

            Customer[] allCustomer = customerList.getAllCustomers();
            for(int i=0;i<allCustomer.length;i++){
                System.out.println((i+1)+"\t"+allCustomer[i].getName()+"\t"+allCustomer[i].getGender()+"\t"+allCustomer[i].getAge()+
                        "\t"+allCustomer[i].getPhone()+"\t"+allCustomer[i].getEmail());
            }
        }


        System.out.println("-------------------------客户列表完成-------------------------\n");
    }

    public static void main(String[] args){
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
