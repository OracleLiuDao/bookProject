package com.liudao.pojo;
import org.omg.PortableInterceptor.INACTIVE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车对象
 */
public class Cart {
/*    //总商品数量
    private Integer totalCount;
    //总价格
    private BigDecimal totalPrice;*/
    //商品项
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();
    //private List<CartItem> items = new ArrayList<CartItem>();


    public Integer getTotalCount() {
       Integer totalCount = 0;
        for(Map.Entry<Integer,CartItem> entry : items.entrySet()){
            totalCount+=entry.getValue().getCount();
        }
        return totalCount;
    }



    public BigDecimal getTotalPrice() {
      BigDecimal  totalPrice = new BigDecimal(0);
        for(Map.Entry<Integer,CartItem> entry : items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());

        }
        return totalPrice;
    }



    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }



    //加入购物车
    public void addItem(CartItem cartItem){
        //先判断购物车有没有商品,有,数量做累加,金额更新,没有,直接放入map集合
        //怎么查看这个商品加入购物车了没有
        //购物车的物品的商品编号是唯一的,判断一下okk
        CartItem item = items.get(cartItem.getId());
        if(item==null){
            //为空时没有添加
            items.put(cartItem.getId(),cartItem);
        }else{   //数量累加
                item.setCount(item.getCount()+1);
                //multiply乘,bigDecumal大的小数->getcount数量 ->更新总金额
                item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }

    }
    public void deleteItem(Integer id){
        items.remove(id);

    }
    public void clear(){
           items.clear();
    }
    //修改商品数量
    public void clear(Integer id,Integer count){
        //查看购物车是否有商品,有修改商品数量,更该金额
        CartItem cartItem = items.get(id);
        if(cartItem!=null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }

    }


}


   /* //添加商品项
    public void addItem(CartItem cartItem){
        //查看购物车是否添加过该商品,如果添加,累加
        CartItem item = items.get(cartItem.getId());
        if (item == null){
            items.put(cartItem.getId(),cartItem);
        }else {
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }

    }
    //删除商品项
    public void deleteItem(Integer id){
        items.remove(id);
    }
    //清空购物车
    public void clear(){
        items.clear();
    }
    //修改商品数量
    public void updateItem(Integer id,Integer count){
// 先查看购物车中是否有此商品。如果有，修改商品数量，更新总金额
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);// 修改商品数量
            cartItem.setTotalPrice( cartItem.getPrice().multiply(new BigDecimal( cartItem.getCount() )) ); // 更新总金额
        }
    }



    public Integer getTotalCount() {
        Integer totalCount = 0;

        for (Map.Entry<Integer,CartItem>entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }



    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for (Map.Entry<Integer,CartItem>entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }



    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
*/