//1. Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите исходную строку: ");
        String str1 = scanner.nextLine();
        System.out.println("Введите подстроку для поиска: ");
        String str2 = scanner.nextLine();

        if (str1.contains(str2)) {
            System.out.println("Подстрока найдена в исходной строке.");
        } else {
            System.out.println("Подстрока не найдена в исходной строке.");
        }
    }
}

//2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую строку: ");
        String str1 = scanner.nextLine();
        System.out.println("Введите вторую строку: ");
        String str2 = scanner.nextLine();

        if (str1.length() != str2.length()) {
            System.out.println("Строки не являются вращением друг друга.");
        } else {
            String str3 = str1 + str1;
            if (str3.contains(str2)) {
                System.out.println("Строки являются вращением друг друга.");
            } else {
                System.out.println("Строки не являются вращением друг друга.");
            }
        }
    }
}

// 3. *Напишите программу, чтобы перевернуть строку с помощью рекурсии.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для переворота: ");
        String str = scanner.nextLine();
        System.out.println("Перевернутая строка: " + reverse(str));
    }

    public static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }
}

//4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 
// Используем метод StringBuilder.append().

public class Main {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 56;
        StringBuilder sb = new StringBuilder();

        sb.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2).append("\n");
        sb.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2).append("\n");
        sb.append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2).append("\n");

        System.out.println(sb.toString());
    }
}

//5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("3 + 56 = 59");

        int index = sb.indexOf("=");
        sb.deleteCharAt(index);
        sb.insert(index, "равно");

        System.out.println(sb.toString());
    }
}

// 6. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("3 + 56 = 59");

        int index = sb.indexOf("=");
        sb.replace(index, index + 1, "равно");

        System.out.println(sb.toString());
    }
}

// 7. *Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.

public class Main {
    public static void main(String[] args) {
        String str = "";
        StringBuilder sb = new StringBuilder();

        // Создание строки с 10000 символов "="
        for (int i = 0; i < 10000; i++) {
            str += "=";
            sb.append("=");
        }

        // Замена символа "=" на слово "равно" с помощью String
        long startTime1 = System.nanoTime();
        str = str.replace("=", "равно");
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;
        System.out.println("Время выполнения для String: " + duration1 + " нс");

        // Замена символа "=" на слово "равно" с помощью StringBuilder
        long startTime2 = System.nanoTime();
        int index = sb.indexOf("=");
        while (index >= 0) {
            sb.replace(index, index + 1, "равно");
            index = sb.indexOf("=", index + 1);
        }
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;
        System.out.println("Время выполнения для StringBuilder: " + duration2 + " нс");
    }
}
