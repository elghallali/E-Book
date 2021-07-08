package com.elghallali.ebook.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoroccoStatesConstants {
    public final static String Mar = "Morocco";

    public final static Map<String, String> mapOfMoroccoStates = new HashMap<String, String>() {

        /**
		 * 
		 */
		private static final long serialVersionUID = -8994451625358751588L;

		{

            put("TAN-TET-HOC", "Tanger-Tétouan-Al Hoceïma");
            put("ORI", "L'Oriental");
            put("FE-MEK", "Fès-Meknès");
            put("RAB-SAL-KEN", "Rabat-Salé-Kénitra");
            put("BMEL-KHEN", "Béni Mellal-Khénifra");
            put("CASA-SET", "Casablanca-Settat");
            put("MAR-SAF", "Marrakech-Safi");
            put("DRA-TAF", "Drâa-Tafilalet");
            put("SOU-MAS", "Souss-Massa");
            put("GUE-ONOU", "Guelmim-Oued Noun");
            put("LAA-SAK", "Laâyoune-Sakia El Hamra");
            put("DAK-OED", "Dakhla-Oued Ed-Dahab");

        }
    };

    public final static List<String> listOfMoroccoStatesCode = new ArrayList<>(mapOfMoroccoStates.keySet());
    public final static List<String> listOfMoroccoStatesName = new ArrayList<>(mapOfMoroccoStates.values());

}
