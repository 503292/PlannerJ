import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [
        RouterModule.forChild([
            {
                path: 'region',
                loadChildren: './region/region.module#PlannerRegionModule'
            },
            {
                path: 'country',
                loadChildren: './country/country.module#PlannerCountryModule'
            },
            {
                path: 'location',
                loadChildren: './location/location.module#PlannerLocationModule'
            },
            {
                path: 'department',
                loadChildren: './department/department.module#PlannerDepartmentModule'
            },
            {
                path: 'task',
                loadChildren: './task/task.module#PlannerTaskModule'
            },
            {
                path: 'employee',
                loadChildren: './employee/employee.module#PlannerEmployeeModule'
            },
            {
                path: 'job',
                loadChildren: './job/job.module#PlannerJobModule'
            },
            {
                path: 'job-history',
                loadChildren: './job-history/job-history.module#PlannerJobHistoryModule'
            }
            /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
        ])
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PlannerEntityModule {}
