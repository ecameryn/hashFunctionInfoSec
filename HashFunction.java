
/**
 * This Program Performs a Hash Function on Strings and Stores Them Inside of a LinkedList That is 
 * Allocated Inside of an Hash Table Array's Cell.
 * 
 * @author Cameryn Holstick 
 * 
 */

import java.math.BigInteger;
import java.util.*;

public class HashFunction
{
    BigInteger MAX_HASH_VAL = new BigInteger("1000000"); //2^20
    @SuppressWarnings("unchecked") LinkedList<String> [] hashTable = new LinkedList[MAX_HASH_VAL.intValue()];
    
    public HashFunction ()
    { 
        /*Initialize each cell in hashTable with a LinkedList<String> structure 
           to deal with collisions*/
       if(hashTable[0] == null)
        {
            for(int i = 0; i < hashTable.length; i++)
            {
                hashTable[i] = new LinkedList<String>();
            }
        }
    }
    
    public int hashMe(String toBeHashed)
    {
        /*Create StringBuilder obj and append the ASCII value of each character from the 
           String toBeHashed; Multiply each char by 31(prime#) to enhance uniqueness of hash results*/
        StringBuilder sb = new StringBuilder();
        for (char c : toBeHashed.toCharArray())
            sb.append((int)c*31);
    
        
        /*Convert StringBuilder obj into one large BigInteger obj that will represent the original 
           String toBeHashed*/
        BigInteger hashValNum = new BigInteger(sb.toString());
        
        /*Get the mod of the large value in the BigInteger obj divided by the max amount of cells in 
           the hashTable; hashValMod represents the final hash result*/
        BigInteger hashValMod = hashValNum.mod(MAX_HASH_VAL);
        
        /*Convert hashValMod into an int (bucketNum) that will represnet the cell location of the LinkedList 
           that the String toBeHashed will be added to*/
        int bucketNum = hashValMod.intValue();
        
        /*Add the original String that is now hashed into this cells LinkedList*/
        hashTable[bucketNum].add(toBeHashed);
        
        return bucketNum;
        
    }
   
    public String printCollisionList(int bucketNum)
    {
        String collisionStr = "";
        
        for(int i = 0; i < hashTable[bucketNum].size(); i++)
        {
            collisionStr+="Index "+i+" of bucket number "+bucketNum+" "+hashTable[bucketNum].get(i)+"\n";
        }
        
        return collisionStr+" ----End Of List---- ";
        
    }
    
    
    
}

