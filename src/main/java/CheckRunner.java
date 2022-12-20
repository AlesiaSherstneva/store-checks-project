import models.cards.Card;
import printers.CheckPrinter;
import printers.CheckWriter;
import readers.InputFileReader;
import util.CardsFactory;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRunner {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No data entered!");
            System.exit(1);
        }

        Map<Integer, Integer> shopping = new LinkedHashMap<>();
        var cardObject = new Object() {
            int cardNumber = 0;
        };

        Pattern filePattern = Pattern.compile(".+\\..+");
        Matcher fileMatcher = filePattern.matcher(args[0]);
        if (fileMatcher.find()) {
            args = InputFileReader.readFile(args[0]);
        }

        Pattern numbersPattern = Pattern.compile("\\d+-\\d+");
        Pattern cardsPattern = Pattern.compile("card-\\d+");

        for (String arg : args) {
            Matcher numbersMatcher = numbersPattern.matcher(arg);
            Matcher cardsMatcher = cardsPattern.matcher(arg);
            if (numbersMatcher.find()) {
                String[] parameters = arg.split("-");
                int number = Integer.parseInt(parameters[0]);
                int count = Integer.parseInt(parameters[1]);
                if (shopping.containsKey(number)) {
                    shopping.put(number, shopping.get(number) + count);
                } else {
                    shopping.put(number, count);
                }
            } else if (cardsMatcher.find()) {
                cardObject.cardNumber = Integer.parseInt(arg.substring(cardsMatcher.start() + 5, cardsMatcher.end()));
                break;
            } else {
                System.out.println("Incorrect input data!");
                System.exit(1);
            }
        }

        Optional<Card> card = CardsFactory.getAllCards().stream()
                .filter(object -> object.getNumber() == cardObject.cardNumber)
                .findAny();

        String check = new CheckPrinter().printCheck(shopping, card.isPresent());
        CheckWriter.writeCheckToArchive(check);
        System.out.println(check);
    }
}