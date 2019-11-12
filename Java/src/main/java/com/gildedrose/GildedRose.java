package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";


    public void updateQualityWithPositiveSellIn() {
        for (Item item : items) {
            if (!item.name.equals(AGED_BRIE)
            	&& !item.name.equals(BACKSTAGE)
                && !item.name.equals(SULFURAS)) {         	
                if (QualityAbove0(item)) {
                    	DecreaseQuality(item);
                        if (item.name.equals(CONJURED)) {
                        	DecreaseQuality(item);
                        }	
                }
            }
            else if (QualityUnder50(item)) {
                IncreaseQualite(item);
                if (item.name.equals(BACKSTAGE)) {
                	if (item.sellIn < 11) {
                		if (QualityUnder50(item)) {
                			IncreaseQualite(item);
                        }
                    }
                    if (item.sellIn < 6) {
                    	if (QualityUnder50(item)) {
                    		IncreaseQualite(item);
                        }
                    }
                }
            }
        }
    }
        
    public void DecreaseSellInByDays () {
    	for (Item item : items) {
    		if (!item.name.equals(SULFURAS)) {
    			DecreaseSellIn(item);
            }
    	}
    }

    public void updateQualityWithNegativeSellIn () {
    	for (Item item : items) {
    		if (SellUnder0(item) && QualityAbove0(item)){
    			if (!item.name.equals(AGED_BRIE)) {
    				if (!item.name.equals(BACKSTAGE)) {
    					if (!item.name.equals(SULFURAS)) {
    						DecreaseQuality(item);
                            if (item.name.equals(CONJURED)) {
                            	DecreaseQuality(item);
                            }   
                        }
                    }
    				else {
                    	SetQualityToZero(item);
                    }
                }
    			else if (QualityUnder50(item)) {
                		IncreaseQualite(item);
                }
            }
        }
    }
    
      
    private int DecreaseQuality (Item item){
    	return item.quality = item.quality - 1;
    }
      
    private int IncreaseQualite (Item item){
    	return item.quality = item.quality + 1;
    }
      
    private int SetQualityToZero (Item item){
    	return item.quality = item.quality - item.quality;
    }
      
    private int DecreaseSellIn (Item item){
    	return item.sellIn = item.sellIn - 1;
    }
      
    private boolean QualityUnder50 (Item item) {
    	return item.quality < 50;
    }
   
    private boolean QualityAbove0(Item item) {
    	return item.quality > 0;
    }
    
    private boolean SellUnder0(Item item) {
    	return item.sellIn < 0;
    }
}