package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    /*@Test
    public void testQuality() {
    	Item[] items = new Item[] { new Item("Aged Brie", 2, 0) , 
    			new Item("+5 Dexterity Vest", 10, 20),
    			new Item("Elixir of the Mongoose", 5, 7), 
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), 
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
    	
    }*/
        
    @Test
    public void testSulfura() {
    	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80)}; 
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", items[0].name);	
        assertEquals(0, items[0].sellIn);	
        assertEquals(80, items[0].quality);	
    }
    
    @Test
    public void testConjured () {
    	Item[] items = new Item[] { new Item("Conjured Mana Cake", 4, 8)}; 
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, items[0].quality);
    }
    
    @Test
    public void testBackstage10Days () {
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 8)};
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, items[0].quality);
    }
    
    @Test
    public void testBackstage5Days () {
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 8)};
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, items[0].quality);
    }

}
