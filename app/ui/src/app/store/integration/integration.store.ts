import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { TypeFactory } from '@syndesis/ui/model';
import { IntegrationService } from './integration.service';

import { createIntegration, createStep, Integration, Integrations } from '@syndesis/ui/platform';

import { AbstractStore, EventsService, ChangeEvent } from '../entity';
import { Subject } from 'rxjs/Subject';

@Injectable()
export class IntegrationStore extends AbstractStore<Integration, Integrations, IntegrationService> {
  constructor(integrationService: IntegrationService, eventService: EventsService) {
    super(integrationService, eventService, [], <Integration>{});
  }

  protected get kind() {
    return 'integration';
  }

  setChangeEventsFilter(changeEvents: Subject<ChangeEvent>) {
    return changeEvents.filter(event => event.kind.startsWith('integration'));
  }

  newInstance(): Integration {
    const integration = createIntegration();
    const start = createStep();
    const end = createStep();
    start.stepKind = end.stepKind = 'endpoint';
    integration.steps = [start, end];
    return integration;
  }
}
