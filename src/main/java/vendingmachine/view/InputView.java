package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readChangePrice() {
        return Integer.parseInt(Console.readLine());
    }
}
