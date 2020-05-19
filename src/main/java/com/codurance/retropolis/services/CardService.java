package com.codurance.retropolis.services;

import com.codurance.retropolis.factories.CardFactory;
import com.codurance.retropolis.models.Card;
import com.codurance.retropolis.repositories.CardRepository;
import com.codurance.retropolis.requests.NewCardRequestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final CardFactory cardFactory;

    @Autowired
    public CardService(CardRepository cardRepository, CardFactory cardFactory) {
        this.cardRepository = cardRepository;
        this.cardFactory = cardFactory;
    }

    public Card addCard(NewCardRequestObject requestObject) {
        Card card = cardFactory.create(requestObject);
        return cardRepository.save(card);
    }
}
