import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgbDateAdapter } from '@ng-bootstrap/ng-bootstrap';

import { NgbDateMomentAdapter } from './util/datepicker-adapter';
import { PlannerSharedLibsModule, PlannerSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';
import { PlannerMaterialModule } from 'app/shared/material.module';

@NgModule({
    imports: [PlannerSharedLibsModule, PlannerSharedCommonModule, PlannerMaterialModule],
    declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
    providers: [{ provide: NgbDateAdapter, useClass: NgbDateMomentAdapter }],
    entryComponents: [JhiLoginModalComponent],
    exports: [PlannerSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PlannerSharedModule {
    static forRoot() {
        return {
            ngModule: PlannerSharedModule
        };
    }
}
