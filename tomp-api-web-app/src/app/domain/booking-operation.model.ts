/**
 * operation on the bookingOption
 */
export class BookingOperation {
  operation: BookingOperation.OperationEnum = BookingOperation.OperationEnum.CANCEL;
}
// tslint:disable-next-line: no-namespace
export namespace BookingOperation {
  export type OperationEnum = 'CANCEL' | 'EXPIRE' | 'DENY' | 'COMMIT';
  export const OperationEnum = {
    CANCEL: 'CANCEL' as OperationEnum,
    EXPIRE: 'EXPIRE' as OperationEnum,
    DENY: 'DENY' as OperationEnum,
    COMMIT: 'COMMIT' as OperationEnum
  };
}
