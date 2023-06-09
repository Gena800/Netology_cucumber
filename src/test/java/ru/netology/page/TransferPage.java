package ru.netology.page;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private SelenideElement amountInput = $("[data-test-id='amount'] input");
    private SelenideElement fromInput = $("[data-test-id='from'] input");
    private SelenideElement transferHead = $(byText("Пополнение карты"));


    public TransferPage() {
        transferHead.shouldBe(visible);
    }

    public DashboardPage makeTransfer(String cardFrom, int amountToTransfer) {
        amountInput.setValue(String.valueOf(amountToTransfer));
        fromInput.setValue(cardFrom);
        transferButton.click();
        return new DashboardPage();
    }

}