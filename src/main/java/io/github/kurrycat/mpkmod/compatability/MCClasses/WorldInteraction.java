package io.github.kurrycat.mpkmod.compatability.MCClasses;

import io.github.kurrycat.mpkmod.compatability.API;
import io.github.kurrycat.mpkmod.util.BoundingBox3D;
import io.github.kurrycat.mpkmod.util.Vector3D;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorldInteraction {
    public static List<BoundingBox3D> getCollisionBoundingBoxes(Vector3D blockPosVec) {
        return Interface.get().map(w -> w.getCollisionBoundingBoxes(blockPosVec)).orElseGet(ArrayList::new);
    }
    public interface Interface extends FunctionHolder {
        static Optional<Interface> get() {
            return API.getFunctionHolder(Interface.class);
        }

        List<BoundingBox3D> getCollisionBoundingBoxes(Vector3D blockPosVec);
    }
}