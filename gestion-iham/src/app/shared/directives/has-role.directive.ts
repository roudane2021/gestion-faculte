import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';
import { JwtService } from '../services/jwt-service';

@Directive({
  selector: '[appHasRole]'
})
export class HasRoleDirective {

  hasView: boolean = true;

  constructor(private templateRef: TemplateRef<any>, 
    private viewContainer: ViewContainerRef,
    private jwtService: JwtService) { }

  @Input() set appHasRole(permissions: string[]) {
  console.table(this.jwtService.roles())
    if ( this.jwtService.roles()?.some(role => permissions?.includes(role))) {
    this.viewContainer.createEmbeddedView(this.templateRef);
    this.hasView = true;
    } else {
      this.viewContainer.clear();
      this.hasView = false;
    }
  }

}
