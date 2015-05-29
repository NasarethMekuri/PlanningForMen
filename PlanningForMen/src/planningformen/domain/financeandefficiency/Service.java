/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.financeandefficiency;

import planningformen.domain.planning.Sellable;

/**
 *
 * @author Simon
 */
public class Service implements Sellable
{
    private ServiceType _type;
    private ServiceState _state;
    private ServiceType _garageThatStartedService;
}
