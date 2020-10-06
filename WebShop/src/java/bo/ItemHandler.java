/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ui.ItemInfo;

/**
 *
 * @author vagif
 */
public class ItemHandler 
{
    public static ArrayList<ItemInfo> getItemsWithSearchFor(String searchFor)
    {
        ArrayList<ItemInfo> items = new ArrayList<>();
        List<Item> result = Item.searchItems(searchFor);
        for(Iterator it = result.iterator(); it.hasNext();)
        {
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getName(), item.getDesc(), item.getNrOfItems()));
        }
        return items;
    }
}
