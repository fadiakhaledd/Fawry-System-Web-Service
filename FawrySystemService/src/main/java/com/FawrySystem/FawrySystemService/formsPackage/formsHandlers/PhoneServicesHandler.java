package com.FawrySystem.FawrySystemService.formsPackage.formsHandlers;

import com.FawrySystem.FawrySystemService.formsPackage.forms.Form;
import com.FawrySystem.FawrySystemService.formsPackage.forms.PhoneForm;
import com.FawrySystem.FawrySystemService.paymentPackage.PaymentHandler;
import com.FawrySystem.FawrySystemService.transactionsPackage.models.Transaction;
import com.FawrySystem.FawrySystemService.transactionsPackage.repository.TransactionRepository;
import com.FawrySystem.FawrySystemService.usersPackage.models.Customer;

import java.util.HashMap;

public class PhoneServicesHandler extends FormsHandler {
    HashMap<String, String> extraInformation = new HashMap<>();

    PhoneForm passedForm;

    protected void setPassedForm(PhoneForm passedForm) {
        this.passedForm = passedForm;
    }

    protected void extractInformation() {
        amount = passedForm.getPay_amount();
        paymentType = passedForm.getPaymentType();
        extraInformation.put("phone number",passedForm.getPhoneNumber());
    }

    public boolean choosePayment() {
        PaymentHandler paymentHandler = new PaymentHandler();
        return paymentHandler.choosePaymentStrategy(paymentType, amount, passedForm.getCreditCard());
    }

    private void createTransaction(String spname, Customer currentCustomer, Float amount, Float appliedDiscount) {
        float payAmount = amount - (amount * appliedDiscount);
        TransactionRepository transactionRepository = new TransactionRepository();
        int lastID = TransactionRepository.getTransactions().size() + 1;
        Transaction newTransaction = new Transaction(spname, currentCustomer, payAmount, lastID, extraInformation);
        transactionRepository.addTransaction(newTransaction);
    }



    public boolean handlePaymentRequest(PhoneForm form, String spname, Customer currentCustomer, Float appliedDiscount) {
        setPassedForm(form);
        extractInformation();
        if (choosePayment()) {
            createTransaction(spname, currentCustomer, amount, appliedDiscount);
            return true;
        } return false;
    }


}
