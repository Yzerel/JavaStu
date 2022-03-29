package com.godc.ExceotionTest;

public class ExceptionMain {

    public static void main(String[] args) {
            try {
                try {
                    throw new Sneeze();
                }catch (Annoyance a) {
                    System.out.println("Annoyance");
                    throw a;
                }
            } catch (Sneeze s){
                System.out.println("Sneeze");
                return;
            }
            finally {
                System.out.println("hello world");
            }
        }
}
