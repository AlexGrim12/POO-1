package src.battle;

import java.util.ArrayList;

public interface MegaTransformers {    
    public boolean canTransform(Transformer t1, Transformer t2);
    public void transform(ArrayList<Transformer> b, int i, int j);
}

