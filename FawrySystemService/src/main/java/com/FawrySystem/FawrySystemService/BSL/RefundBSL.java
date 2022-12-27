package com.FawrySystem.FawrySystemService.BSL;

import com.FawrySystem.FawrySystemService.controllers.CustomerController;
import com.FawrySystem.FawrySystemService.models.Transactions.Transaction;

public class RefundBSL {
    private final TransactionsBSL transactionsBSL = new TransactionsBSL();

    public int requestRefund(Integer TID) {
        Transaction toBeRefunded = transactionsBSL.findTransaction(TID);
        if (toBeRefunded != null) {
            if (CustomerController.currentCustomer == toBeRefunded.getCustomer()) {
                // set refund attribute with true to indicate the refund request
                toBeRefunded.setRefund(true);
                // call request refund function to add the transaction to the list of refund requests
                transactionsBSL.requestRefund(toBeRefunded);
                return 3;
            } else return 2;
        } else return 1;
    }

    public boolean acceptRefund(Integer TID) {
        Transaction acceptedRefund = transactionsBSL.findRefund(TID);
        if (acceptedRefund != null) {
            // get the pay amount of the transaction
            double amount = acceptedRefund.getPay_amount();
            // return pay amount to the customer wallet
            acceptedRefund.getCustomer().setWallet(acceptedRefund.getCustomer().getWallet() + amount);
            // set refund attribute into false to indicate the end of the request
            acceptedRefund.setRefund(false);
            // remove request from list of refunds
            transactionsBSL.removeRefundRequest(TID);
            return true;
        }
        return false;
    }


}