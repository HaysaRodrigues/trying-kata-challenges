package RG;

/**
 * @author haysa
 */
public class RG {

    public boolean isRGValid(String rg) {
        if ((rg == null) || (rg == "") || (rg.isEmpty()) || (rg.charAt(8) != '-')) {
            return false;
        }

        return true;
    }

}
