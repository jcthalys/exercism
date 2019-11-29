import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class ResistorColor {
    private Map<String, Integer> colorsCode = new LinkedHashMap<>();
    {
        colorsCode.put("black", 0);
        colorsCode.put("brown", 1);
        colorsCode.put("red", 2);
        colorsCode.put("orange", 3);
        colorsCode.put("yellow", 4);
        colorsCode.put("green", 5);
        colorsCode.put("blue", 6);
        colorsCode.put("violet", 7);
        colorsCode.put("grey", 8);
        colorsCode.put("white", 9);
    }


    int colorCode(String color) {
        return colorsCode.getOrDefault(color, 0);
    }

    String[] colors() {
        final Set<String> colorsSet = colorsCode.keySet();
        return colorsSet.toArray(new String[colorsSet.size()]);
    }
}
