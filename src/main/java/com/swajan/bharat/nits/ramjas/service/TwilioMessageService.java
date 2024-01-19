package com.swajan.bharat.nits.ramjas.service;

import java.util.List;

public interface TwilioMessageService {
    String sendMessage(String phoneNumber);
    List<String> sendMessages();
}
