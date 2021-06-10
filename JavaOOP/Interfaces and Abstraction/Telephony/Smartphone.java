package Telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public List<String> getUrls() {
        return urls;
    }

    @Override
    public String browse() {
        StringBuilder result = new StringBuilder();
        for (String url : urls) {
            if(checkIfTheUrlContainsDigit(url)){
               result.append("Invalid URL!");
            }else{
                result.append("Browsing: ").append(url).append("!");
            }
            result.append(System.lineSeparator());
        }
        return result.toString().trim();
    }

    private boolean checkIfTheUrlContainsDigit(String url) {
        char[] urlToCharArray = url.toCharArray();
        for (char c : urlToCharArray) {
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String call() {
        StringBuilder result = new StringBuilder();

        for (String number : numbers) {
            if(checkIfTheNumberIsOnlyDigits(number)){
                result.append("Calling... ").append(number);
            }else{
                result.append("Invalid number!");
            }

            result.append(System.lineSeparator());
        }
        return result.toString().trim();
    }

    private boolean checkIfTheNumberIsOnlyDigits(String number) {
        char[] numberToCharArray = number.toCharArray();
        for (char c : numberToCharArray) {
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}
