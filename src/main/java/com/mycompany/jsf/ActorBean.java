/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.jsf;

import com.mycompany.ejb.ActorFacade;
import com.mycompany.entity.Actor;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author agajkowski
 */
@Named(value = "actorBean")
@SessionScoped
public class ActorBean implements Serializable{
    private List<Actor> actors;
    @Inject
    private ActorFacade eao;

    public ActorBean() {
    }

    @PostConstruct
    public void init() {
        initActorList();
    }
    public void initActorList() {
        actors = eao.findAll();
    }
    
    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
    
    
}
