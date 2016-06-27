//Alex Dao

public class Calc
{    

    private double currentValue;   
    
    public Calc() 
    {
        currentValue = 0;
    }

    private double toNum(String n) 
    {
        int decimalCounts = 0;
        int firstIndex = n.indexOf(".");
        String revised = n;

        if(firstIndex == -1)
        {
            revised=n;
        }

        else
        {
            for(int i = 0; i < n.length(); i++)
            {
                int index = (n).substring(i).indexOf(".");
                if(index != -1)
                {
                    decimalCounts++;
                }
            }

            if(decimalCounts == 1)
            {
                revised=n;
            }

            if (decimalCounts > 1)
            {
                int length = n.length();
                for(int i = 0; i < length; i++)
                {
                    int index = n.substring(i).indexOf(".") + i;
                    if(index != firstIndex)
                    {
                        revised = n.substring(0, index) + n.substring(index+1);
                    }
                }
            }
        }

        return Double.parseDouble(revised);
    }

    
    public String getTotalString() 
    {
        return "" + currentValue;
    }
    
    public void setTotal(String n) 
    {
        currentValue = toNum(n);
    }
    
    public void add(String n) 
    {
        currentValue += toNum(n);
    }
    
    public void subtract(String n) 
    {
        currentValue -= toNum(n);
    }
    
    public void multiply(String n) 
    {
        currentValue *= toNum(n);
    }
    
    public void divide(String n) 
    {   
        currentValue /= toNum(n);
    }
    
}