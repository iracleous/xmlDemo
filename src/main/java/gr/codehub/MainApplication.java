package gr.codehub;

import gr.codehub.usecase.UseCase;

public class MainApplication {
    public static void main(String[] args) {
        UseCase useCase = new UseCase();

        useCase.useCase1();
        useCase.useCase2();
        useCase.useCase3();
    }
}
