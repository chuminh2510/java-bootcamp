package com.minhcv.java11.interfaces;

public class InterfaceImplementationApp {
    interface Face1 {
        void face1();

        void face();

        default void doSomething() {
            System.out.println("Face1.doSomething");
        }

        static void invoke() {
            System.out.println("Face1.invoke");
        }
    }

    interface Face2 {
        void face2();

        void face();
    }

    interface Face3 {
        void face3();

        int face(int a);
    }

    interface Face extends Face1, Face2 {
        @Override
        void face1();

        @Override
        void face2();

    }

    class FaceImpl1 implements Face {

        @Override
        public void face1() {

        }

        @Override
        public void face2() {

        }

        @Override
        public void face() {

        }
    }

    class FaceImpl2 implements Face1, Face3 {

        @Override
        public void face1() {

        }

        @Override
        public void face() {

        }

        @Override
        public void face3() {

        }

        @Override
        public int face(int a) {
            return 0;
        }

    }

    class Faceimpl extends FaceImpl1 {

    }

    abstract class AbsFace implements Face {

        @Override
        public void face() {
            System.out.println("AbsFace.face");
        }
    }

    class AbsFaceImpl extends AbsFace {

        @Override
        public void face() {

        }

        @Override
        public void face1() {

        }

        @Override
        public void face2() {

        }
    }

    public static void main(String[] args) {
        Face face;
        Face1.invoke();
    }
}
