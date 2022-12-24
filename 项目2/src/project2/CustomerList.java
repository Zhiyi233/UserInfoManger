package project2;

public class CustomerList {
    private Customer[] customers; //用来保存客户对象数组
    private int total; //记录已保存客户对象的数量


    /**
     * 用途：构造器，用来初始化customers数组
     * 参数：totalCustomer：指定customers数组的最大空间
     * @param totalCustomer
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * 用途：返回参数index指定索引位置的客户对象记录
     * 参数： index指定所要获取的客户在数组中的索引位置，从0开始
     * 返回：封装了客户信息的Customer对象
     * @param index
     * @return
     */
    public Customer getCustomer(int index){
        //因为total相当于长度即客户个数，在数组中index最大为total-1
        if(index<0 || index>=total){
            return null;
        }
        return this.customers[index];
    }


    /**
     * 用途：返回数组中记录的所有客户对象
     * 返回： Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同
     * @return
     */
    public Customer[] getAllCustomers() {
       Customer[] cust = new Customer[total];
       for(int i=0;i<total;i++){
           cust[i] = customers[i];
       }
       return cust;
    }

    public int getTotal() {
        return this.total;
    }

    /**
     * 用途：从数组中删除参数index指定索引位置的客户对象记录
     * 参数： index指定所删除对象在数组中的索引位置，从0开始
     * 返回：删除成功返回true；false表示索引无效，无法删除
     * @param index
     * @return
     */
    public boolean deleteCustomer(int index){
        if(index<0 || index>total){
            return false; //index无效，无法删除
        }
        for(int i = index;i<total-1;i++){
            customers[i] = customers[i+1];
        }
        customers[total-1] = null;
        total--;
        return true;
    }

    /**
     * 用途：用参数customer替换数组中由index指定的对象
     * 参数：customer指定替换的新客户对象
     * 	   index指定所替换对象在数组中的位置，从0开始
     * 返回：替换成功返回true；false表示索引无效，无法替换
     * @param index
     * @param cust
     * @return
     */
    public boolean replaceCustomer(int index, Customer cust){
        if(index<0 || index>=total){
            return false; //index无效，无法删除
        }
        customers[index] = cust;
        return true;
    }

    /**
     * 用途：将参数customer添加到数组中最后一个客户对象记录之后
     * 参数：customer指定要添加的客户对象
     * 返回：添加成功返回true；false表示数组已满，无法添加
     * @param customer
     * @return
     */
    public boolean addCustomer(Customer customer){
        if(total >= customers.length){
            return false; //长度到达最大满了
        }
        customers[total] = customer;
        total++;
        return true;
    }
}
