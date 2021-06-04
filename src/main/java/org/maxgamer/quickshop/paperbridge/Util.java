package org.maxgamer.quickshop.paperbridge;

import com.sun.istack.internal.NotNull;

public class Util {
    /**
     * Get this class available or not
     *
     * @param qualifiedName class qualifiedName
     * @return boolean Available
     */
    public static boolean isClassAvailable(@NotNull String qualifiedName) {
        try {
            Class.forName(qualifiedName);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
