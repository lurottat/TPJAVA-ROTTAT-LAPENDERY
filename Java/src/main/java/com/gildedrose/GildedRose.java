package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQualityWithPositiveSellIn() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (IsAboveLowestQualityValue(item)) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    	DecreaseQuality(item);
                        if (item.name.equals("Conjured Mana Cake")) {
                        	DecreaseQuality(item);
                        }
                    		
                    }
                }
            } else {
                if (IsUnderHighestQualityValue(item)) {
                	IncreaseQualite(item);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (IsUnderHighestQualityValue(item)) {
                            	IncreaseQualite(item);
                            }
                        }

                        if (item.sellIn < 6) {
                            if (IsUnderHighestQualityValue(item)) {
                            	IncreaseQualite(item);
                            }
                        }
                    }
                }
            }
        }
      }
        
      public void DecreaseSellInByDays () {
    	  for (Item item : items) {
      
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                DecreaseSellIn(item);
            }
    	  }
      }

      public void updateQualityWithNegativeSellIn () {
    	  for (Item item : items) {
            if (IsUnderLowestSellValue(item)) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (IsAboveLowestQualityValue(item)) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            	DecreaseQuality(item);
                                if (item.name.equals("Conjured Mana Cake")) {
                                	DecreaseQuality(item);
                                }
                                
                            }
                        }
                    } else {
                    	SetQualityToZero(item);
                    }
                } else {
                    if (IsUnderHighestQualityValue(item)) {
                    	IncreaseQualite(item);
                    }
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
      
      private boolean IsUnderHighestQualityValue(Item item) {
    	  return item.quality < 50;
      }
   
      private boolean IsAboveLowestQualityValue(Item item) {
    	  return item.quality > 0;
      }
      private boolean IsUnderLowestSellValue(Item item) {
    	  return item.sellIn < 0;
      }
}