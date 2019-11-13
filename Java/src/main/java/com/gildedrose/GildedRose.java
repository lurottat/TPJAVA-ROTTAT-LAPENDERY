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


    public void UpdateItem() {
        for (Item item : items) {
        	
        	if (item.name.equals(SULFURAS)) { continue; }
        	
        	if(item.name.equals("Aged Brie")) { UpdateAgedBrie(item); }
        	
        	else if (item.name.equals(BACKSTAGE)) { UpdateBackstage(item); }
        	
        	else { UpdateOtherItemsWithSellAbove0(item); }
        	
        	if (SellUnder0(item)) { UpdateOtherItemsWithSellUnder0(item); }
        }
   }
    
    protected void UpdateBackstage(Item item) {
		DecreaseSellIn(item);
		IncreaseQuality(item);
    	if (item.sellIn < 11) { IncreaseQuality(item);}
        if (item.sellIn < 6) { IncreaseQuality(item);}
        if (item.sellIn < 0) { SetQualityToZero(item);}
    }
    
    protected void UpdateAgedBrie(Item item) {
		DecreaseSellIn(item);// Probleme ICI
		IncreaseQuality(item);
		if (SellUnder0(item)) {
			IncreaseQuality(item);
			IncreaseQuality(item);
		}
    }

    protected void UpdateOtherItemsWithSellAbove0(Item item) {
		DecreaseSellIn(item);
		DecreaseQuality(item);
        if (item.name.equals(CONJURED)) {
        	DecreaseQuality(item);
        }	
    }
    
    protected void UpdateOtherItemsWithSellUnder0(Item item) {
		DecreaseSellIn(item);
		DecreaseQuality(item);
		if (item.name.equals(CONJURED)) {
            DecreaseQuality(item);
		}
    }
   
    protected void DecreaseQuality (Item item){
    	if (QualityAbove0(item)) {
    		item.quality = item.quality - 1;
    	}
    }
      
    protected void IncreaseQuality (Item item){
    		if (QualityUnder50 (item)) {
    			item.quality = item.quality + 1;
    		}
    }
      
    protected void SetQualityToZero (Item item){
    	item.quality = item.quality - item.quality;
    }
      
    protected void DecreaseSellIn (Item item){
    	item.sellIn = item.sellIn - 1;
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