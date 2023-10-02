package com.systechafrica.pos;

public class Item {
    int mem=6;
    private int itemCode[]=new int[mem];
    private int itemPrice[]=new int[mem];
  
    public int[] getItemCode() {
        return itemCode;
    }
    public void setItemCode(int[] itemCode) {
    itemCode = itemCode;
    }
    public int[] getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(int[] itemPrice) {
        itemPrice = itemPrice;
    }
}