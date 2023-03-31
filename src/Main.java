
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();

        try {
            Reader reader = new FileReader("Задача ВС Java Сбер.csv");
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                if (parts.length < 6) {
                    System.err.println("Неполная строка: " + line);
                    continue;
                }
                City city = new City();
                city.setName(parts[1].trim());
                city.setRegion(parts[2].trim());
                city.setDistrict(parts[3].trim());
                city.setPopulation(Integer.parseInt(parts[4].trim()));
                city.setFoundation(parts[5].trim());
                cities.add(city);
            }
            scanner.close();
        } catch (IOException e) {
            System.err.println("Не удалось найти или прочитать файл: " + e.getMessage());
        }

        // Сортировка по наименованию в алфавитном порядке по убыванию без учета регистра
//        cities.sort((city1, city2) -> city2.getName().compareToIgnoreCase(city1.getName()));
//
//        for (City city : cities) {
//            System.out.println(city);
//        }

//        System.out.println("\nСортировка по федеральному округу и наименованию города внутри каждого федерального округа:");
//
//        // Сортировка по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра
//        cities.sort((city1, city2) -> {
//            int districtComparison = city1.getDistrict().compareTo(city2.getDistrict());
//            if (districtComparison != 0) {
//                return districtComparison;
//            } else {
//                return city2.getName().compareTo(city1.getName());
//            }
//        });

//        for (City city : cities) {
//            System.out.println(city);
//        }
        // Найти город с наибольшим количеством жителей
        City cityWithLargestPopulation = cities.get(0);
        int cityIndex = 0;
        for (int i = 1; i < cities.size(); i++) {
            if (cities.get(i).getPopulation() > cityWithLargestPopulation.getPopulation()) {
                cityWithLargestPopulation = cities.get(i);
                cityIndex = i;
            }
        }
        System.out.println("[" + cityIndex + "] = " + cityWithLargestPopulation.getPopulation());
// либо так
        cities.sort(Comparator.comparingInt(City::getPopulation));
        City cityLargestPopulation = cities.get(cities.size() - 1);
        int cityIndex1 = cities.indexOf(cityLargestPopulation);
        System.out.println("[" + cityIndex1 + "] = " + cityLargestPopulation.getPopulation());


        Map<String, Integer> regionCounts = new HashMap<>();
        for (City city : cities) {
            String region = city.getRegion();
            if (regionCounts.containsKey(region)) {
                regionCounts.put(region, regionCounts.get(region) + 1);
            } else {
                regionCounts.put(region, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : regionCounts.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}




