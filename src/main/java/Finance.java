import com.h2.BestLoanRates;
import com.h2.MortgageCalculator;
import com.h2.SavingsCalculator;

import java.util.Arrays;
import java.util.Map;

public class Finance {
    public final static String BEST_LOAN_RATES = "bestLoanRates";
    public final static String SAVINGS_CALCULATOR = "savingsCalculator";
    public final static String MORTGAGE_CALCULATOR = "mortgageCalculator";

    public final static Map<String, String> commandsToUsage = Map.of(
            BEST_LOAN_RATES, "usage: bestLoanRates",
            SAVINGS_CALCULATOR, "usage: savingsCalculator <credits separated by ','> <debits separated by ','>",
            MORTGAGE_CALCULATOR, "usage: mortgageCalculator <loanAmount> <termInYears> <annualRate>"
    );

    public static void main(String[] args) {
        // check for invalid command
        String command = args[0];
        if (!commandsToUsage.containsKey(command)) {
            System.out.println(command + ": command not found");
            return;
        }

        // check for invalid command arguments
        boolean isValidCommand = validateCommandArguments(args);
        if (!isValidCommand) {
            System.out.println(commandsToUsage.get(args[0]));
            return;
        }

        // if all is well, run the program
        executeCommand(command, Arrays.copyOfRange(args, 1, args.length));
    }

    private static boolean validateCommandArguments(String[] args) {
        // check that the requested app has the right number of arguments
        switch (args[0]) {
            case BEST_LOAN_RATES:
                return args.length == 1;
            case SAVINGS_CALCULATOR:
                return args.length == 3;
            case MORTGAGE_CALCULATOR:
                return args.length == 4;
        }

        return false;
    }

    /**
     * Call the appropriate calculator from the command line
     * @param command - name of calculator to use
     * @param arguments - parameters to pass in to the calculator (e.g. credits, loanAmount...)
     */
    private static void executeCommand(String command, String[] arguments) {
        switch(command) {
            case BEST_LOAN_RATES:
                System.out.println("Finding best loan rates ...");
                BestLoanRates.main(arguments);
                return;
            case SAVINGS_CALCULATOR:
                System.out.println("Finding your net savings ...");
                SavingsCalculator.main(arguments);
                return;
            case MORTGAGE_CALCULATOR:
                System.out.println("Finding your monthly payment ...");
                MortgageCalculator.main(arguments);
                return;
        }
    }
}
