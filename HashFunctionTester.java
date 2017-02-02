
/**
 * Tests HashFunction Class.
 * 
 * @author Cameryn Holstick 
 */
public class HashFunctionTester
{
    public static void main(String[] args)
    {
        HashFunction hashFunc = new HashFunction();
        
        int hashVal1, hashVal2, hashVal3, hashVal4, hashVal5;
        hashVal1 = hashFunc.hashMe("ElectraCamerynHolstick");
        hashVal2 = hashFunc.hashMe("ElectraCamerynH");
        hashVal3 = hashFunc.hashMe("ElectraCamHolstick");
        hashVal4 = hashFunc.hashMe("Camaroon");
        hashVal5 = hashFunc.hashMe("Electric");
        
        
        System.out.println(hashFunc.printCollisionList(hashFunc.hashMe("ElectraCamerynHolstick")));
        System.out.println(hashFunc.printCollisionList(102232));
        System.out.println(hashFunc.printCollisionList(413410));
        System.out.println(hashFunc.printCollisionList(553069));
        System.out.println(hashVal1+"/"+ hashVal2+"/"+ hashVal3+"/"+ hashVal4+"/"+ hashVal5);
        
   }
}
