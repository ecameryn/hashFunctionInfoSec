
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
    LinkedList<String> collisionChain = new LinkedList<String>();
    String toBeHashedAsNode;
    int bucket = 0;
    
    public HashFunction ()
    { 
        /*Initialize the each cell in hashTable with a LinkedList<String> structure*/
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
           String that will be hashed; Multiply each char by 31(prime#) to enhance uniquness of hash results*/
        StringBuilder sb = new StringBuilder();
        for (char c : toBeHashed.toCharArray())
            sb.append((int)c*31);
    
        
        /*Convert StringBuilder obj into one large BigInteger obj representing the original 
           String that will be hashed*/
        BigInteger hashValNum = new BigInteger(sb.toString());
        
        /*Get the mod of the large BigInteger obj divided by the max amount of positions in 
           the hashTable; hashValMod represents the final hash result*/
        BigInteger hashValMod = hashValNum.mod(MAX_HASH_VAL);
        
        /*Convert hashValMod into an int*/
        int bucketNum = hashValMod.intValue();
        
        /*Add the original String that is now hashed into this buckets LinkedList*/
        hashTable[bucketNum].add(toBeHashed);
        
        return bucketNum;
        
    }
   
    public String printCollisionList(int bucketNum)
    {
        for(int i = 0; i < hashTable[bucketNum].size(); i++)
        {
            System.out.println("Index "+i+" of bucket number "+bucketNum+" "+hashTable[bucketNum].get(i));
        }
        
        return " ----End Of List---- ";
        
    }
    
    
    
}

