package application;

import entities.Athlete;

import java.util.*;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List <Athlete> list = new ArrayList<>();

        System.out.print("Quantas a quantidade de atletas? ");
        int n = sc.nextInt();

        for (int i=1; i <= n; i++) {
            System.out.println("Digite os dados do atleta numero " + i + ":");
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Sexo: ");
            String type = sc.next();
            while (!type.equals("M") && !type.equals("F")) {
                System.out.print("Valor invalido! Favor digitar F ou M: ");
                type = sc.next();
            }

            System.out.print("Altura: ");
            double height = sc.nextDouble();
            while (height <= 0) {
                System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                height = sc.nextDouble();
            }

            System.out.print("Peso: ");
            double weight = sc.nextDouble();
            while (weight <= 0) {
                System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                weight = sc.nextDouble();
            }

            list.add(new Athlete(name, type, height, weight));
        }

        double manWeight = 0;
        double count = 0;
        double countType = 0;
        double countWoman = 0;
        double womanHeight = 0;

        for (Athlete athlete : list) {
            manWeight += athlete.getWeight();
            count += 1;
            if (athlete.getType().equals("M")){
                countType += 1;
            } else if (athlete.getType().equals("F")) {
                womanHeight += athlete.getHeight();
                countWoman += 1;
            }
        }
        double avgWeight = manWeight / count;
        double mansPercent = countType / count * 100;
        double avgHeight = womanHeight / countWoman;
        Athlete tallestAthlete = Collections.max(list, Comparator.comparingDouble(Athlete::getHeight));

        System.out.println();
        System.out.println("RELATÓRIO");
        System.out.println("Peso médio dos atletas: " + String.format("%.2f", avgWeight));
        System.out.println("Atleta mais alto: " + tallestAthlete.getName());
        System.out.printf("Porcentagem de homens: %s %%%n", String.format("%.1f", mansPercent));

        if (avgHeight > 0) {
            System.out.println("Altura média das mulheres: " + String.format("%.2f", avgHeight));
        } else {
            System.out.println("Não há mulheres cadastradas");
        }

        sc.close();

    }
}