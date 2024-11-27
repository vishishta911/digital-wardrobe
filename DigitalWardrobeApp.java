import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class ClothingItem {
    private String type;
    private String color;
    private String size;
    private String season;
    private String brand;

    public ClothingItem(String type, String color, String size, String season, String brand) {
        this.type = type;
        this.color = color;
        this.size = size;
        this.season = season;
        this.brand = brand;
    }
    public String getType() { 
        return type;
    }
    public String toString() {
        return "Type: " + type + ", Color: " + color + ", Size: " + size + ", Season: " + season + ", Brand: " + brand;
    }
}
class Wardrobe {
    private List<ClothingItem> items;

    public Wardrobe() {
        items = new ArrayList<>();
    }

    public void addItem(ClothingItem item) {
        items.add(item);
    }

    public void removeItem(ClothingItem item) {
        items.remove(item);
    }

    public List<ClothingItem> filterByType(String type) {
        List<ClothingItem> result = new ArrayList<>();
        for (ClothingItem item : items) {
            if (item.getType().equalsIgnoreCase(type)) {
                result.add(item);
            }
        }
        return result;
    }

    public void displayItems() {
        for (ClothingItem item : items) {
            System.out.println(item);
        }
    }
}


public class DigitalWardrobeApp {
    public static void main(String[] args) {
        Wardrobe wardrobe = new Wardrobe();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Add Item\n2. Remove Item\n3. View Wardrobe\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.println("Enter type, color, size, season, brand:");
                    String type = scanner.nextLine();
                    String color = scanner.nextLine();
                    String size = scanner.nextLine();
                    String season = scanner.nextLine();
                    String brand = scanner.nextLine();
                    wardrobe.addItem(new ClothingItem(type, color, size, season, brand));
                    break;
                case 2:
                    System.out.println("Enter type and brand of the item to remove:");
                    String removeType = scanner.nextLine();
                    String removeBrand = scanner.nextLine();
                    clothingItem itemToRemove = new ClothingItem(removeType, removeBrand);
                    if (wardrobe.filterByType(removeType).contains(itemToRemove)) {
                        wardrobe.removeItem(itemToRemove);
                        System.out.println("Item removed successfully.");
                    } else {
                        System.out.println("Item not found in the wardrobe.");
                    }
                    break;
                case 3:
                    wardrobe.displayItems();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
