package src.battle;

import java.util.ArrayList;

public interface MegaTransformers {    
    public boolean teamCanFusion(ArrayList<Transformer> b);
    public boolean canFusion();
    public void fusion(ArrayList<Transformer> b, int i, int j);
}
