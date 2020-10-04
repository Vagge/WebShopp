/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author vagif
 */
public class ItemInfo 
{
    private String name;
    private String desc;
    private int nrOfItems;
    
    public ItemInfo(String name, String desc, int nrOfItems)
    {
        this.name = name;
        this.desc = desc;
        this.nrOfItems = nrOfItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNrOfItems() {
        return nrOfItems;
    }

    public void setNrOfItems(int nrOfItems) {
        this.nrOfItems = nrOfItems;
    }
    
}
