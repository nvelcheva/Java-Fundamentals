class Car {
    private String brand;
    private String model;
    private String color;
    private int power;
    private String engineType;
    private String gearboxType;
    private int yearOfProduction;
    
    public Car() {
        this.brand = "";
        this.model = "";
        this.color = "";
        this.power = 0;
        this.engineType = "";
        this.gearboxType = "";
        this.yearOfProduction = 0;
    }


    public Car(String brand, String model, String color, int power, String engineType, String gearboxType, int yearOfProduction) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.power = power;
        this.engineType = engineType;
        this.gearboxType = gearboxType;
        this.yearOfProduction = yearOfProduction;
    }

    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void printInfo() {
        System.out.println(brand + " " + model + " (" + color + "), " + yearOfProduction + "g.");
    }
}


class Test {

    
    public static Car[] filterByLetter(Car[] cars, char letter) {
        int count = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getBrand().charAt(0) == letter || cars[i].getBrand().charAt(0) == Character.toUpperCase(letter)) {
                count++;
            }
        }

        Car[] result = new Car[count];
        int index = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getBrand().charAt(0) == letter || cars[i].getBrand().charAt(0) == Character.toUpperCase(letter)) {
                result[index] = cars[i];
                index++;
            }
        }
        return result;
    }

    public static Car[] sortByBrand(Car[] cars, boolean ascending) {
        Car[] sorted = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            sorted[i] = cars[i];
        }

        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted.length - 1 - i; j++) {
                int comparison = sorted[j].getBrand().compareTo(sorted[j + 1].getBrand());
                
                if (ascending) {
                    if (comparison > 0) {
                        Car temp = sorted[j];
                        sorted[j] = sorted[j + 1];
                        sorted[j + 1] = temp;
                    }
                } else {
                    if (comparison < 0) {
                        Car temp = sorted[j];
                        sorted[j] = sorted[j + 1];
                        sorted[j + 1] = temp;
                    }
                }
            }
        }
        return sorted;
    }
    public static Car[] removeDuplicates(Car[] cars) {
        int uniqueCount = 0;
        
        boolean[] isDuplicate = new boolean[cars.length];
        for (int i = 0; i < cars.length; i++) {
            if (isDuplicate[i]) continue;
            uniqueCount++;
            for (int j = i + 1; j < cars.length; j++) {
                if (cars[i].getBrand().equalsIgnoreCase(cars[j].getBrand()) &&
                    cars[i].getModel().equalsIgnoreCase(cars[j].getModel()) &&
                    cars[i].getYearOfProduction() == cars[j].getYearOfProduction()) {
                    isDuplicate[j] = true;
                }
            }
        }

        Car[] uniqueCars = new Car[uniqueCount];
        int index = 0;
        for (int i = 0; i < cars.length; i++) {
            if (!isDuplicate[i]) {
                boolean alreadyAdded = false;
                for (int k = 0; k < index; k++) {
                    if (uniqueCars[k].getBrand().equalsIgnoreCase(cars[i].getBrand()) &&
                        uniqueCars[k].getModel().equalsIgnoreCase(cars[i].getModel()) &&
                        uniqueCars[k].getYearOfProduction() == cars[i].getYearOfProduction()) {
                        alreadyAdded = true;
                        break;
                    }
                }
                if (!alreadyAdded) {
                    uniqueCars[index] = cars[i];
                    index++;
                }
            }
        }
        
        Car[] finalResult = new Car[index];
        for (int i = 0; i < index; i++) {
            finalResult[i] = uniqueCars[i];
        }
        return finalResult;
    }

    public static void main(String[] args) {
        Car[] garage = new Car[5];
        garage[0] = new Car("BMW", "320", "Black", 150, "Diesel", "Manual", 2005);
        garage[1] = new Car("Audi", "A4", "Silver", 140, "Diesel", "Automatic", 2008);
        garage[2] = new Car("BMW", "530", "Blue", 231, "Petrol", "Automatic", 2004);
        garage[3] = new Car("Opel", "Astra", "Red", 101, "Petrol", "Manual", 2002);
        garage[4] = new Car("BMW", "320", "Black", 150, "Diesel", "Manual", 2005); // дубликат

        for (int i = 0; i < garage.length; i++) {
            garage[i].printInfo();
        }

        Car[] filtered = filterByLetter(garage, 'b');
        for (int i = 0; i < filtered.length; i++) {
            filtered[i].printInfo();
        }

        Car[] sortedAsc = sortByBrand(garage, true);
        for (int i = 0; i < sortedAsc.length; i++) {
            sortedAsc[i].printInfo();
        }

        Car[] unique = removeDuplicates(garage);
        for (int i = 0; i < unique.length; i++) {
            unique[i].printInfo();
        }
    }
}