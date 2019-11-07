package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void testQualityOther () {
    	Item[] items = new Item[] {  
    			new Item("+5 Dexterity Vest", 5, 4),
    			new Item("Elixir of the Mongoose", 5, 4), 
				new Item("+5 Dexterity Vest", -5, 4),
				new Item("Elixir of the Mongoose", -5, 4)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (int i = 0 ; i < items.length ; i++) {
        	if (items[i].sellIn > 0 ) {
        		assertEquals(3,items[i].quality);
        	}
        	else {
        		assertEquals(2,items[i].quality);
        	}
        }
    }
	
	@Test
	public void testSellIn () {
		Item[] items = new Item[] { 
		new Item("+5 Dexterity Vest", 10, 20), 
        new Item("Aged Brie", 10, 0), 
        new Item("Elixir of the Mongoose", 10, 7),
        new Item("Elixir of the Mongoose", 10, 7), 
        new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
        new Item("Conjured Mana Cake", 10, 6) };
		GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (int i = 0 ; i < items.length ; i++) {
        		assertEquals(9,items[i].sellIn);
        }
	}
        
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
    public void testQualityConjured () {
    	Item[] items = new Item[] { 
    			new Item("Conjured Mana Cake", 4, 8), 
    			new Item("Conjured Mana Cake", -4, 8)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (int i = 0 ; i < items.length ; i++) {
        	if (items[i].sellIn > 0) {
        		assertEquals(6,items[i].quality);
        	}
        	else {
        		assertEquals(4,items[i].quality);
        	}
        }
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
    
    @Test
    public void testBackstageDateSoldExceeded () {
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 8)};
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }
    
    @Test
    public void testQualityNeverOver50 () {
    	Item[] items = new Item[] { 
    			new Item("Aged Brie", 5, 50) , 
    			new Item("Elixir of the Mongoose", 5, 50),  
                new Item("Conjured Mana Cake", 3, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (int i = 0 ; i < items.length ; i++) {
        	assertTrue(items[i].quality < 51);
        }
    }
    
    @Test
    public void testQualityNeverLower0 () {
    	Item[] items = new Item[] { 
    			new Item("+5 Dexterity Vest", 10, 0),
    			new Item("Elixir of the Mongoose", 5, 0), 
                new Item("Conjured Mana Cake", 3, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (int i = 0 ; i < items.length ; i++) {
        	assertFalse(items[i].quality < 0);
        }
    }
    
    @Test
    public void testQualityAgedBrie () {
    	Item[] items = new Item[] { 
    		new Item("Aged Brie", 5, 8),
    		new Item("Aged Brie", -5, 8)};
    	GildedRose app = new GildedRose(items);
        app.updateQuality();
        System.out.println(items[0].quality);
        System.out.println(items[1].quality);
        for (int i = 0 ; i < items.length ; i++) {
        	if (items[i].sellIn > 0) {
        		assertEquals(9,items[i].quality);
        	}
        	else {
        		assertEquals(10,items[i].quality);
        	}
        }
    }
}
