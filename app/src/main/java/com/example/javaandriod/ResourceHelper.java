package com.example.javaandriod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public class ResourceHelper {
//    //private static int[] allPhotoResIds= new int[]{R.drawable.photo1, R.drawable.photo2, R.drawable.photo3};
//    private static ArrayList<Integer> allPhotoResIds = new ArrayList<>(Arrays.asList(R.drawable.photo1, R.drawable.photo2, R.drawable.photo3));
//    private  static String[] allPhotoNames= new String[]{ "android", "opel astra", "jamnik" };
//
//    private static String[] allPhotoCategory = { "Zwierzęta", "Samochody", "Zwierzęta" };
//    final String[] categories = {"Android", "Samochody", "Zwierzęta", "Różne"};
////    public static void setAllPhotos(int[] photoResIds, String[] photoNames) {
////        allPhotoResIds = new int[]{R.drawable.photo1, R.drawable.photo2, R.drawable.photo3};
////        allPhotoNames = new String[]{ "android", "opel astra", "jamnik" };
////    }
//
//    public static int[] getAllPhotoResIds() {
//        // Zamień ArrayList na tablicę intów
//        int[] photoResIdsArray = new int[allPhotoResIds.size()];
//        for (int i = 0; i < allPhotoResIds.size(); i++) {
//            photoResIdsArray[i] = allPhotoResIds.get(i);
//        }
//        return photoResIdsArray;
//    }
//
//    public static String[] getAllPhotoNames() {
//        return allPhotoNames;
//    }
//    public static String[] getAllCategory() {
//        return allPhotoCategory;
//    }
//
//
//    public static void addPhoto(int photoResId, String photoName, String category) {
//        allPhotoResIds.add(photoResId);
//        allPhotoNames.add(photoName);
//        allPhotoCategory.add(category);
//    }
//}

public class ResourceHelper {
    private static ArrayList<Integer> allPhotoResIds = new ArrayList<>(Arrays.asList(R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.lab, R.drawable.west,R.drawable.android2,R.drawable.bmw));
    private static ArrayList<String> allPhotoNames = new ArrayList<>(Arrays.asList("android", "opel astra", "jamnik","lablador","west","zielony android","bmw"));
    private static ArrayList<String> allPhotoCategories = new ArrayList<>(Arrays.asList("Android", "Samochody", "Zwierzęta","Zwierzęta","Zwierzęta","Android","Samochody"));
    final static String[] categories = {"Android", "Samochody", "Zwierzęta", "Różne"};

    public static int[] getAllPhotoResIds() {
        // Zamień ArrayList na tablicę intów
        int[] photoResIdsArray = new int[allPhotoResIds.size()];
        for (int i = 0; i < allPhotoResIds.size(); i++) {
            photoResIdsArray[i] = allPhotoResIds.get(i);
        }
        return photoResIdsArray;
    }

    public static String[] getAllPhotoNames() {
        return allPhotoNames.toArray(new String[0]);
    }

    public static String[] getAllCategory() {
        return allPhotoCategories.toArray(new String[0]);
    }

    public static void addPhoto(int photoResId, String photoName, String category) {
        allPhotoResIds.add(photoResId);
        allPhotoNames.add(photoName);
        allPhotoCategories.add(category);
    }
    public static int getPhotoIndex(String photoName) {
        for (int i = 0; i < allPhotoNames.size(); i++) {
            if (allPhotoNames.get(i).equals(photoName)) {
                return i;
            }
        }
        return -1; // Zwraca -1, jeśli nie znaleziono zdjęcia o podanej nazwie
    }

    public static void editPhotoInfo(String oldPhotoName, String newPhotoName, String newCategory) {
        int photoIndex = getPhotoIndex(oldPhotoName);

        if (photoIndex != -1) {
            // Znaleziono zdjęcie o podanej nazwie, dokonaj edycji
            allPhotoNames.set(photoIndex, newPhotoName);
            allPhotoCategories.set(photoIndex, newCategory);
        } else {
            // Zdjęcie o podanej nazwie nie zostało znalezione
            // Tutaj można podjąć dodatkowe kroki w razie potrzeby
        }
    }
}