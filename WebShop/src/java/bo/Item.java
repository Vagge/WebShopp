/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import db.ItemDB;
import java.util.List;

/**
 *
 * @author vagif
 */
public class Item 
{
    private int id;
    private String name;
    private String desc;
    private int nrOfItems;
    
    protected Item(int id, String name, String desc, int nrOfItems)
    {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.nrOfItems = nrOfItems;
    }
    
    public static List searchItems(String searchFor)
    {
        return ItemDB.searchItems(searchFor);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public static void main(String[] args)
    {
        List<Item> a = Item.searchItems("");
        System.out.println(a.size());
        for (int i = 0; i < a.size(); i++) 
        {
            System.out.println(a.get(i).getName());
        }
    }
}
