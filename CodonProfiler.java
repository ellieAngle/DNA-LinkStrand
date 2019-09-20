import java.util.*;

public class CodonProfiler {
	
	/**
	 * Count how many times each codon in an array of codons occurs
	 * in a strand of DNA. Return int[] such that int[k] is number
	 * of occurrences of codons[k] in strand. Strand codons can start
	 * at all valid indexes that are multiples of 3: 0, 3, 6, 9, 12, ...
	 * @param strand is DNA to be analyzed for codon occurrences.
	 * @param codons is an array of strings, each has three characters
	 * @return int[] such that int[k] is number of occurrences of codons[k] in 
	 * strand. 
	 */
	public int[] getCodonProfile(IDnaStrand strand, String[] codons) {
		HashMap<String,Integer> map = new HashMap<>();
		int[] ret = new int[codons.length];		
		for(String cod : codons) {
			map.putIfAbsent(cod, 0);
		}
		String str = "";
		for (int k = 0; k < strand.size()-3; k+=3) {
			str = str.substring(k, k+3);
			if (map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
			}
		}
		int dex = 0;
		for (String cd: codons) {
			ret[dex] = map.get(cd);
			dex++;
		}
		return ret;
	}
}
