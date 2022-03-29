package com.godc.ExceotionTest;

public class ExceotionTest {

    static class Annoyance extends Exception{}
    static class Sneeze extends Annoyance{}

    public static void main(String[] args) {
            try{
                try{
                    throw new Sneeze();
                }catch (Annoyance a){
                    System.out.println("Annoyance");
                    throw a;
                } catch (Exception e) {
                    System.out.println("Exception");
                    throw e;
                }
            }catch (Sneeze s){
                System.out.println("Sneeze");
            }finally {
                System.out.println("hello world");
            }
    }
}
