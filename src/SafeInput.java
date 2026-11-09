import java.util.Scanner;

public class SafeInput
{
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int value;
        boolean done = false;

        do
        {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");

            if(pipe.hasNextInt())
            {
                value = pipe.nextInt();
                pipe.nextLine();

                if(value >= low && value <= high)
                {
                    return value;
                }
                else
                {
                    System.out.println("Value must be between " + low + " and " + high);
                }
            }
            else
            {
                System.out.println("Invalid integer.");
                pipe.nextLine();
            }

        } while(!done);

        return 0;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response;

        do
        {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine();
        }
        while(!response.equalsIgnoreCase("Y") &&
                !response.equalsIgnoreCase("N"));

        return response.equalsIgnoreCase("Y");
    }
}