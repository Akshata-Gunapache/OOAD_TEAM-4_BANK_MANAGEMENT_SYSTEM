package com.example.bank.api;

import com.example.bank.model.TransferReq;
import com.example.bank.service.TransferService;
import com.example.bank.service.impl.ImplTransferImpl;
import com.example.bank.service.impl.RegularTransferImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping("/send")
    public ResponseEntity sendMoney(@RequestBody TransferReq transferReq){
        //createFactory(transferReq.getTranserType());
    return transferService.sendMoney(transferReq);
    }

    /**
     * Factory design pattern to generate the object to perform the transfer request
     * @param transferType
     * @return
     */
    private void createFactory(String transferType){
        if(transferType.equalsIgnoreCase("MONEY")){
            this.transferService = new RegularTransferImpl();
        } else if (transferType.equalsIgnoreCase("IMPS")) {
           this.transferService = new RegularTransferImpl();
        }
        this.transferService = new RegularTransferImpl();
    }

}
